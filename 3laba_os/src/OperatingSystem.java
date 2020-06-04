import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OperatingSystem {
	static Random rand = new Random();
	public static Memory memory;
	private Management management;
	private List<Process> processes;
	private static List<Page> pages;

	public OperatingSystem(int memorySize, int pageSize) {
		memory = new Memory(memorySize, pageSize);
		this.management = new Management();
		this.processes = new ArrayList<Process>();
		pages = new ArrayList<Page>();
	}

	public void addProcess() {
		Process process = new Process(this.processes.size(), rand.nextInt(5));
		this.processes.add(process);
		System.out.println(
				"Creating a new process " + process.getId() + " requiring " + process.getCountPages() + " pages");
	}

	public Process getProcess(int processId)
        {
            for (Process process : this.processes)
            {
                if (process.getId() == processId)
                {
                    return process;
                }
            }
            return null;
        }

	public void addPage(int processId) {
		Process process = this.getProcess(processId);
		if (process != null) {
			int pageId = this.management.addPage(process);
			this.getPage(processId, pageId);
			System.out.println("Creating page " + pageId + " for process " + process.getId());
		}
	}

	public void getPage(int processId, int pageId) {
		Process process = this.getProcess(processId);
		if (process != null) {
			if (process.getPagesIds().contains(pageId)) {
				this.management.getPage(pageId);
				System.out.println("Process " + process.getId() + " requested page " + pageId);
			} else {
				System.out.println("У процесса " + process.getId() + " нет страницы " + pageId);
			}
		}
	}

	public void printMemory() {
		System.out.println("Operating memory:");
		System.out.println("   Page   Process   Recourse  ");
		for (int pageId = 0; pageId < memory.getPagesCount(); pageId++) {
			Page page = memory.getPage(pageId);
			if (page == null) {
				System.out.println(" |    " + pageId);
			} else {
				Process process = this.getProcess(page.getProcessId());
				System.out.println(
						" |    " + pageId + " |    " + process.getId() + " |    " + page.isRecourse());
			}
		}
	}

	public static Page returnPage(int pageId) {
		return pages.get(pageId);
	}
}
