import java.util.ArrayList;
import java.util.List;

public class Process
    {
        private int id;
        private int countPages;
        private ArrayList<Integer> pagesIds;
        private ArrayList<Page> processes;


        public Process(int id, int countPages)
        {
            this.id = id;
            this.countPages = countPages;
            this.processes = new ArrayList<Page>();
            this.pagesIds = new ArrayList<Integer>();
        }
        public int getCountPages()
        {
            return countPages;
        }
        public int getId()
        {
            return id;
        }
        public List<Integer> getPagesIds()
        {
            return pagesIds;
        }
        public Page getPage(Integer pageId)
        {
            return processes.get(pageId);
        }
        public int addPage(Page page)
        {
            processes.add(page);
            return processes.indexOf(page);
        }
    }
