class Solution {

    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> res = new ArrayList<List<String>>();
        HashMap<String, List<String>> map = new HashMap<>();
        for (String path : paths) {
            StringBuilder dir = new StringBuilder();
            int i = 0;
            while (path.charAt(i) != ' ') {
                dir.append(path.charAt(i) + "");
                i++;
            }
            i++;
            System.out.println(path.charAt(i));
            StringBuilder FileName = new StringBuilder();
            StringBuilder content = new StringBuilder();
            while (i < path.length()) {
                if (path.charAt(i) == '(') {
                    i++;
                    while (path.charAt(i) != ')') {
                        content.append(path.charAt(i)+"");
                        i++;
                    }
                    if (map.containsKey(content.toString())) {
                        map.get(content.toString()).add(dir.toString() +"/" +FileName.toString());
                    } else {
                        List<String> lst = new ArrayList<>();
                        lst.add(dir.toString() +"/"+ FileName.toString());
                        map.put(content.toString(), lst);
                    }
                    FileName = new StringBuilder();
                    content = new StringBuilder();
                    i++;
                } else {
                    FileName.append(path.charAt(i) + "");
                }
                i++;
            }
        }

        for(List<String> lst: map.values()) {
            if(lst.size() > 1) res.add(lst);
        }
        return res;
    }
}
