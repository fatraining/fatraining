package training2016.model;

import org.apache.commons.lang3.StringUtils;

import training2016.annotations.SimpleCondition;
import training2016.annotations.ToInteger;
import training2016.annotations.ToString;

/**
 * エリア検索条件モデル
 *
 * @author harasan
 */
public class AreaSearchCondition extends AbstractSearchCondition {

	@SimpleCondition(name="id")
	@ToInteger
	private String id;

	@SimpleCondition(name="name")
	@ToString
	private String name;

	/**
	 * コンストラクタ
	 */
	public AreaSearchCondition() {
		super(Area.class);
	}

	/**
	 * idを返す
	 *
	 * @return id
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * idをセットする
	 *
	 * @param id セットする id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * nameを返す
	 *
	 * @return name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * nameをセットする
	 *
	 * @param name セットする name
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * 検索条件が一つでもセットされていればtrue
	 */
	@Override
	public boolean hasCondition() {
		return this.hasName() || this.hasId();
	}

	/**
	 * IDがセットされているか
	 *
	 * @return されていればtrue
	 */
	private boolean hasId() {
		return StringUtils.isNotEmpty(this.id);
	}

	/**
	 * 名称がセットされているか
	 *
	 * @return されていればtrue
	 */
	private boolean hasName() {
		return StringUtils.isNotEmpty(this.name);
	}
}
