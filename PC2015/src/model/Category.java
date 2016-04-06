package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 区分マスタ
 * @author t.makino
 *
 */
@Entity
@Table(name = "category_master")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//===============================
	// フィールド宣言
	//===============================
	/**
	 * 区分コード
	 */
	private String category;
	/**
	 * 区分値
	 */
	private String categoryValue;
	/**
	 * 補助区分コード
	 */
	private String subCategory;
	/**
	 * 補助区分値
	 */
	private String subCategoryValue;

	//===============================
	// setter
	//===============================
	/**
	 * 区分コード
	 * @param category
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * 区分値
	 * @param categoryValue
	 */
	public void setCategoryValue(String categoryValue) {
		this.categoryValue = categoryValue;
	}

	/**
	 * 補助区分コード
	 * @param subCategory
	 */
	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	/**
	 * 補助区分値
	 * @param subCategoryValue
	 */
	public void setSubCategoryValue(String subCategoryValue) {
		this.subCategoryValue = subCategoryValue;
	}

	//===============================
	// getter
	//===============================
	/**
	 * 区分コード
	 * @return category
	 */
	@Id
	@GeneratedValue
	@Column(name = "Category")
	public String getCategory() {
		return category;
	}

	/**
	 * 区分値
	 * @return categoryValue
	 */
	@Column(name = "CategoryValue")
	public String getCategoryValue() {
		return categoryValue;
	}

	/**
	 * 補助区分コード
	 * @return
	 */
	@Column(name = "SubCategory")
	public String getSubCategory() {
		return subCategory;
	}

	/**
	 * 補助区分値
	 * @return subCategoryValue
	 */
	@Column(name = "SubCategoryValue")
	public String getSubCategoryValue() {
		return subCategoryValue;
	}

}
