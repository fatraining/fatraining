package com.example.demo.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

/**
 * 詳細：https://gist.github.com/ryo-murai/3741340
 * @author Created by YaoHaitao on 2018/3/13.
 * @since 2018-03-13 14:51
 */

@Data
@Entity
public class User {

    // @Id 主キーを指定
    @Id
    // @GeneratedValue を使って主キーにユニークな値を自動で生成し、@Id を持つフィルドに適用できます。
    // 詳細：https://qiita.com/KevinFQ/items/a6d92ec7b32911e50ffe
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;

}
