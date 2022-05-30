package ir.finto.mvvmproject.model;

import java.util.List;

public class ApiStackResponse {
    public List<Items> items;
    public boolean has_more;
    public int backoff;
    public int quota_max;
    public int quota_remaining;
}
