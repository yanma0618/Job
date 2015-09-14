package SL;

public class DesktopSearch {
	
}
/**
	Listing 5.8. Producer and Consumer Tasks in a Desktop Search Application.
public class FileCrawler implements Runnable {
	private final BlockingQueue<File> fileQueue;
	private final FileFilter fileFilter;
	private final File root;
	...
	public void run() {
		try {
			crawl(root);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
	private void crawl(File root) throws InterruptedException {
		File[] entries = root.listFiles(fileFilter);
		if (entries != null) {
			for (File entry : entries)
				if (entry.isDirectory())
					crawl(entry);
				else if (!alreadyIndexed(entry))
					fileQueue.put(entry);
		}
	}
}

public class Indexer implements Runnable {
	private final BlockingQueue<File> queue;
	public Indexer(BlockingQueue<File> queue) {
		this.queue = queue;
	}
	
	public void run() {
		try {
			while (true)
				indexFile(queue.take());
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}

Listing 5.9. Starting the Desktop Search.
public static void startIndexing(File[] roots) {
	BlockingQueue<File> queue = new LinkedBlockingQueue<File>(BOUND);
	FileFilter filter = new FileFilter() {
		public boolean accept(File file) { return true; }
	};
	for (File root : roots)
		new Thread(new FileCrawler(queue, filter, root)).start();
	for (int i = 0; i < N_CONSUMERS; i++)
		new Thread(new Indexer(queue)).start();
}
**/