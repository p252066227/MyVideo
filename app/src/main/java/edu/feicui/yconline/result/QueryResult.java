package edu.feicui.yconline.result;


import java.util.List;


public class QueryResult<T> {

    private List<T> results;

    public List<T> getResults() {
        return results;
    }

//     {
//        "results": [{...},{...}]
//    }
}
