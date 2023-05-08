package com.group.testtask.data;

import com.group.testtask.data.Base.Named;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Department extends Named {

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Lector> list = new ArrayList<>();

    @OneToOne
    private Lector headOfDepartment ;

    public Department(Long id, String name, List<Lector> list, Lector headOfDepartment) {
        super(id, name);
        this.list = list;
        this.headOfDepartment = headOfDepartment;
    }
}