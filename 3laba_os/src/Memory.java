import java.util.ArrayList;

public class Memory {
	private ArrayList<Page> pages;
	private ArrayList<Page> tablePage;
	private int countPage;
	private int index;

	public Memory(int memory, int size) {
		pages = new ArrayList<Page>();
		tablePage = new ArrayList<Page>();
		countPage = memory / size;

		for (int i = 0; i < (memory * 2) / size; i++) {
			Page page = new Page(false, false);
			page.setNumber(Integer.MAX_VALUE);
			pages.add(page);
		}
		index = 0;
	}

	private void clockAlgorithm(Page page) {
		for (;;) {
			if (index == tablePage.size()) {
				index = 0;
			}
			if (tablePage.get(index).isRadius()) {
				tablePage.get(index).setRadius(false);
				index++;
			} else {
				tablePage.get(index).setPresence(false);
				tablePage.get(index).setNumber(Integer.MAX_VALUE);
				tablePage.remove(index);
				tablePage.add(index, page);
				page.setNumber(index);
				page.setRadius(true);
				page.setPresence(true);
				System.out.println(index);
				index++;
				return;
			}
		}
	}

	public void inputNumber(int pageIndex) {
		Page page = pages.get(pageIndex);
		if (!page.isPresence()) {
			if (tablePage.size() < countPage) {
				page.setPresence(true);
				page.setRadius(true);
				tablePage.add(page);
				int indexOfPage = tablePage.indexOf(page);
				page.setNumber(indexOfPage);
			} else if (tablePage.size() == countPage) {
				clockAlgorithm(page);
			}
		} else {
			page.setRadius(true);
		}
		printPageFrames();
		printPages();
	}

	public int getSize() {
		return pages.size();
	}

	public void printPageFrames() {
		int i = 0;
		for (Page current_page : tablePage) {
			System.out.println(" " + i + " " + current_page.isRadius() + " " + current_page.isPresence());
			i++;
		}
		System.out.println();
	}

	private void printPages() {
		for (int i = 0; i < pages.size(); i++) {
			System.out.println(" " + i + " " + pages.get(i).isRadius() + " " + pages.get(i).isPresence()
					+ " " + pages.get(i).getNumber() + " ");
		}
		System.out.println();
	}
}
