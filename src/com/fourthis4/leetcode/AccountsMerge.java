package com.fourthis4.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 给定一个列表 accounts，每个元素 accounts[i] 是一个字符串列表，其中第一个元素 accounts[i][0] 是 名称 (name)，其余元素是 emails 表示该账户的邮箱地址。
 *
 * 现在，我们想合并这些账户。如果两个账户都有一些共同的邮箱地址，则两个账户必定属于同一个人。请注意，即使两个账户具有相同的名称，它们也可能属于不同的人，因为人们可能具有相同的名称。一个人最初可以拥有任意数量的账户，但其所有账户都具有相同的名称。
 *
 * 合并账户后，按以下格式返回账户：每个账户的第一个元素是名称，其余元素是按顺序排列的邮箱地址。账户本身可以以任意顺序返回。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/accounts-merge
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        Map<String, Integer> all = new HashMap<>();

        int[] t = new int[accounts.size()];
        for (int i = 0; i < t.length; i++) {
            t[i] = i;
        }

        for (int i = 0; i < accounts.size(); i++) {
            List<String> account = accounts.get(i);

            for (int j = 1; j < account.size(); j++) {
                if (all.containsKey(account.get(j))) {
                    union(t, all.get(account.get(j)), i);
                } else {
                    all.put(account.get(j), i);
                }
            }
        }

        Map<Integer,List<String>> result = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            int root = find(t, i);
            if (result.containsKey(root)) {
                List<String> temp = result.get(root);
                temp.addAll(accounts.get(i).subList(1, accounts.get(i).size()));
            } else {
                result.put(root, accounts.get(i));
            }
        }

        List<List<String>> list = new ArrayList<>();

        result.forEach((k, v) -> {
            List<String> b = v.subList(1, v.size());
            List<String> a = b.stream().distinct().sorted().collect(Collectors.toList());
            List<String> c = new ArrayList<>();
            c.add(v.get(0));
            c.addAll(a);
            list.add(c);
        });
        return list;
    }

    private void union(int[] t, int i, int j) {
        int root = find(t, i);

        t[find(t,j)] = root;
    }
    private int find(int[] t, int i) {
        if (t[i] == i) {
            return i;
        } else {
            return find(t, t[i]);
        }
    }

    public static void main(String[] args) {
        AccountsMerge obj = new AccountsMerge();
        List<String> a = new ArrayList<>(Arrays.asList("David","David0@m.co","David1@m.co"));
        List<String> b = new ArrayList<>(Arrays.asList("David","David3@m.co","David4@m.co"));
        List<String> c = new ArrayList<>(Arrays.asList("David","David4@m.co","David5@m.co"));
        List<String> d = new ArrayList<>(Arrays.asList("David","David2@m.co","David3@m.co"));
        List<String> e = new ArrayList<>(Arrays.asList("David","David1@m.co","David2@m.co"));

        List<List<String>> list = Arrays.asList(a, b, c, d, e);

        list = obj.accountsMerge(list);
        list.stream().forEach(i -> {
            i.forEach(ii -> System.out.print(ii));
            System.out.println();
        });
    }
}
