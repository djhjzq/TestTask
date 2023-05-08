package com.group.testtask.data.Base;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "named")
public class Named extends Base {

    @Column(name = "name", nullable = false)
    private String name;

    public Named(Long id, String name) {
        super(id);
        this.name = name;
    }
}