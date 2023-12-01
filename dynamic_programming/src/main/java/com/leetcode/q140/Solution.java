package com.leetcode.q140;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        var n = s.length();
        var sentences = new HashMap<Integer, List<String>>();
        var empty = new ArrayList<String>();
        empty.add("");
        sentences.put(0, empty);

        for (var i = 0; i <= n; i++) {
            if (!sentences.containsKey(i)) {
                continue;
            }

            for (var word : wordDict) {
                var len = i + word.length();
                if (len <= n && s.startsWith(word, i)) {
                    var lst = sentences.getOrDefault(len, new ArrayList<>());
                    var suffix = word + (len == n ? "" : " ");
                    for (var sentence : sentences.get(i)) {
                        lst.add(sentence + suffix);
                    }
                    sentences.put(len, lst);
                }
            }
        }
        return sentences.getOrDefault(n, new ArrayList<>());
    }
}
