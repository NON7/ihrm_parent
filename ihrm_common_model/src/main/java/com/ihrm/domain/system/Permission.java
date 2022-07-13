package com.ihrm.domain.system;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name="pe_permission")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@DynamicInsert(true)
@DynamicUpdate(true)
public class Permission implements Serializable {
    private static final long serialVersionUID=-4990810027542971546L;
    @Id
    private String id;
    /**
     * 权限名称
     */
    private String name;
    /**
     * 权限类型 1为菜单 2为功能 3为API
     */
    private Integer type;
    /**
     * 权限编码
     */
    private String code;
    /**
     * 权限描述
     */
    private String description;

    private String pid;
    /**
     * 可见状态
     */
    private String envisible;

    public Permission(String name,Integer type,String code,String description){
        this.name=name;
        this.type=type;
        this.code=code;
        this.description=description;
    }

    @JsonIgnore
    @ManyToMany
    public Set<Role> roles=new HashSet<>();
}
