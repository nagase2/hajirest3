package com.example.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
@ToString(exclude="customers")
public class User {
	 @Id //usernameを主キーにする
	 private String username;
	 @JsonIgnore //クラスをJSON出力した時にこのフィr−るど除外されるようにする。
	 private String encodedPassword;
	 @JsonIgnore
	 //fetch =FetchType.LAZYで関連エンティティを遅延ロードさせることができる（←他には？）この場合,customerフィールドにアクセスした時点で、データが読み込まれる。
	 //cascade=CascadeType.ALLでUserの永続化操作や削除操作を関連先のCustomerにも伝搬させることができる。
	 //双方向の関係にする場合は、mappedByで関連先でのプロパティ名を指定する。
	 @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="user")
	 private List<Customer> customers;

}
