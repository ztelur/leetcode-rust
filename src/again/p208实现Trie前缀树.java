package again;

class Trie {
    private Trie[] children;
    private boolean isEnd;

    public Trie() {
        // 一个 Trie 的数组，一共有 26 个，代表 26 个字母。
        children = new Trie[26];
        isEnd = false;
    }

    public void insert(String word) {
        // node 表示当前的 node
        Trie node = this;
        // 对 word 进行遍历
        for (int i = 0; i < word.length(); i++) {
            // 获得当前char
            char ch = word.charAt(i);
            // 进行 - 'a' 获取对应的 index
            int index = ch - 'a';
            // 查看 children 的 index 的是否为空，如果不为空，则创建一个
            if (node.children[index] == null) {
                node.children[index] = new Trie();
            }
            // 进行遍历下一个
            node = node.children[index];
        }
        // 最后一个节点设置成 finish
        node.isEnd = true;
    }

    public boolean search(String word) {
        // 根据前缀获取一个 Node
        Trie node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    private Trie searchPrefix(String prefix) {

        Trie node = this;
        // 根据 charAt 不断进行 children
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                return null;
            }
            node = node.children[index];
        }
        return node;
    }
}
