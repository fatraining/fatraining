package jp.co.futureantiques.webapptraining.model.bandSasaki;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import lombok.Data;
@Data
@Entity
public class MemberSasaki {
@Id
@GeneratedValue
@Column(name="id")
private int id;

@Column(name="member")
private String member;

@Column(name="del_flg")
private String delFlg;

@Column(name="create_date")
private String createDate;

@Column(name="update_date")
private String updateDate;

@Transient
@OneToMany(targetEntity=BandMainSasaki.class, mappedBy="member")
@JoinColumn(name="id", referencedColumnName="member_id")
private List<BandMainSasaki> bandMainSasakiList;
}
