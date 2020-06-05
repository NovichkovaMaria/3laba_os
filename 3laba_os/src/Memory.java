import java.util.ArrayList;

public class Memory {
	private ArrayList<Page> pages;
	private ArrayList<Page> tablePage;
	private int time;

	public Memory(int memory, int size) {
		pages = new ArrayList<Page>();
		tablePage = new ArrayList<Page>();

		for (int i = 0; i < (memory * 8) / size; i++) {
			Page page = new Page();
			pages.add(page);
		}

		for (int i = 0; i < memory / size / 2; i++) {
			tablePage.add(pages.get(i));
		}
		time = 1;
	}
	
	public void inputNumber(int index){
        Page page = pages.get(index);
        
        if (!tablePage.contains(page)) {
        	algorithm(page);
        }

        page.setPresence(true);
        page.setLastTime(time);
        
        time++;
        
        if (time % 8 == 0) {
        	clearUsed();
        }
        
        printPageFrames();
        printPages();
    }

	private void algorithm(Page page) {
		ArrayList<Page> delet = new ArrayList<Page>();

		for (int i = 0; i < tablePage.size(); i++) {
			Page currentPage = tablePage.get(i);

			if (!currentPage.isPresence()) {
				delet.add(currentPage);
			}
		}

		delet = delet.isEmpty() ? tablePage : delet;
		Page pageDelet = delet.get(0);

		for (int i = 0; i < delet.size(); i++) {
			Page currentPage = delet.get(i);

			if (currentPage.getLastTime() < pageDelet.getLastTime()) {
				pageDelet = currentPage;
			}
		}

		tablePage.remove(pageDelet);
		tablePage.add(page);
	}

	public int getSize() {
		return pages.size();
	}
	
	private void clearUsed() {
    	for (int i = 0; i < tablePage.size(); i++) {
    		Page currentPage = tablePage.get(i);
    		currentPage.setPresence(false);
    	}
    }


	public void printPageFrames() {
		System.out.println("Table of page blocks");
        System.out.println("i\tisUsed\tlastTime");
        
        for (int i = 0; i < tablePage.size(); i++) {
    		Page currentPage = tablePage.get(i);
            System.out.println(i + "\t" + currentPage.isPresence() + "\t" + currentPage.getLastTime());
        }
        
        System.out.println();
	}

	private void printPages() {
		 System.out.println("Page table");
	        System.out.println("i\tisUsed\tlastTime");
	        
	        for (int i = 0; i < pages.size(); i++) {
	    		Page currentPage = pages.get(i);
	            System.out.println(i + "\t" + currentPage.isPresence() + "\t" + currentPage.getLastTime());
	        }
	        
	        System.out.println();
	}
}
