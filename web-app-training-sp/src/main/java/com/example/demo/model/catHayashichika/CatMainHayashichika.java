package com.example.demo.model.catHayashichika;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 *CatMainHayashichikaテーブルと対応するEntity
 *
 * @author future
 */
@Data
@Entity
public class CatMainHayashichika {
	/**猫ID*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	/**猫種名*/
	@Column(name = "cat_name")
	private String catName;

	/**毛種ID*/
	@Column(name = "type_id")
	private Integer typeId;

	/**体型ID*/
	@Column(name = "size_id")
	private Integer sizeId;

	/**原産国ID*/
	@Column(name = "from_id")
	private Integer fromId;

	/**特徴 */
	@Column(name = "point")
	@Size(max = 255)
	private String point;

	/**削除フラグ*/
	@Column(name = "del_flag")
	private String delFlag;

	/**登録日時*/
	@Column(name = "create_date")
	private Timestamp createDate;

	/**更新日時*/
	@Column(name = "update_date")
	private Timestamp updateDate;

	/**外部キー設定:毛種*/
	@ManyToOne(targetEntity = TypeHayashichika.class)
	@JoinColumn(name = "type_id", insertable = false, updatable = false)
	private TypeHayashichika typeHayashichika;

	/**外部キー設定:体型*/
	@ManyToOne(targetEntity =SizeHayashichika.class)
	@JoinColumn(name = "size_id", insertable = false, updatable = false)
	private SizeHayashichika sizeHayashichika;

	/**外部キー設定:原産国*/
	@ManyToOne(targetEntity = FromHayashichika.class)
	@JoinColumn(name = "from_id", insertable = false, updatable = false)
	private FromHayashichika fromHayashichika;

}
