package ir.finto.mvvmproject.model;

import java.util.List;

public class ApiStackResponse {
    private List<Items> items;
    private boolean has_more;
    private int backoff;
    private int quota_max;
    private int quota_remaining;
}
