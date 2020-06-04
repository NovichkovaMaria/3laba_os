import java.util.ArrayList;

public class Management {
	private Process process;
	private ArrayList<Page> clock;

	public void MemoryManagment()
    {
        process = new Process(5, 15);
        this.clock = new ArrayList<Page>();
    }

	public int addPage(Process process) {
		int pageId = this.process.addPage(new Page(process.getId()));
		process.getPagesIds().add(pageId);
		return pageId;
	}

	public Page getPage(int pageId) {
		Page page = this.process.getPage(pageId);
		if (page.isPresent()) {
			page.setRecourse(true);
		} else {
			int emptyPageId = OperatingSystem.memory.getEmptyPageId();
			if (emptyPageId != -1) {
				OperatingSystem.memory.setPage(emptyPageId, page);
				page.setRecourse(true);
				page.setPresence(true);
				page.setPhysicalAddress(emptyPageId);
				this.clock.add(page);
			} else {
				while (true) {
					Page replacePage = this.clock.get(0);
					clock.remove(clock.size() - 1);
					if (replacePage.isRecourse()) {
						replacePage.setRecourse(false);
						this.clock.add(replacePage);
					} else {
						if (replacePage.getVirtualAddress() != -1) {
							OperatingSystem.memory.setPage(replacePage.getPhysicalAddress(),
									OperatingSystem.returnPage(replacePage.getVirtualAddress()));
						} else {
							OperatingSystem.memory.setPage(replacePage.getPhysicalAddress(), page);
						}
						page.setRecourse(true);
						page.setPresence(true);
						page.setPhysicalAddress(replacePage.getPhysicalAddress());
						this.clock.add(page);
						replacePage.setPresence(false);
						replacePage.setVirtualAddress(process.addPage(replacePage));
						replacePage.setPhysicalAddress(-1);
						break;
					}
				}
			}
		}
		return page;
	}
}
