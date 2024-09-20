package org.example.dto;

public interface AbstractDto<ID> {
    ID getId();

    void setId(ID id);
}
