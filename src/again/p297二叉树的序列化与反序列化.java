package again;

import java.TreeNode;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Codec {
    public String serialize(TreeNode root) {
        /// 进行序列化
        return rserialize(root, "");
    }

    public TreeNode deserialize(String data) {
        // 进行解序列化
        String[] dataArray = data.split(",");
        // 将数据split 然后进行
        List<String> dataList = new LinkedList<>(Arrays.asList(dataArray));
        return rdeserialize(dataList);
    }

    public String rserialize(TreeNode root, String str) {
        if (root == null) {
            str += "None,";
        } else {
            // 深度遍历
            str += str.valueOf(root.val) + ",";
            // 遍历左节点
            str = rserialize(root.left, str);
            // 遍历右节点
            str = rserialize(root.right, str);
        }
        return str;
    }

    public TreeNode rdeserialize(List<String> dataList) {
        // 如果当前为 None，则表示是 null，将其删除，然后返回null
        if (dataList.get(0).equals("None")) {
            dataList.remove(0);
            return null;
        }

        // 获取第一个数据，然后生成root
        TreeNode root = new TreeNode(Integer.valueOf(dataList.get(0)));
        // 删除
        dataList.remove(0);
        // 处理 left 的
        root.left = rdeserialize(dataList);
        // 处理right的
        root.right = rdeserialize(dataList);

        return root;
    }
}
