import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Random;

public class Read {

	RandomAccessFile file;
	File fileToRead = new File("D:\\Рабочий стол\\file.txt");
	int size = 16;

	public Read() {
		try {
			file = new RandomAccessFile(fileToRead, "rw");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void read() {
		FileChannel fileChannel = file.getChannel();
		try {
			MappedByteBuffer mbb = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, size);

			// read data from
			while (true) {
				mbb.rewind();
				if (mbb.getInt() == Flag.WRITE.FLAG) {
					int x = mbb.getInt();
					int y = mbb.getInt();
					System.out.println(" sum " + (x + y));
				}
				mbb.rewind();
				mbb.putInt(Flag.READ.FLAG);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
