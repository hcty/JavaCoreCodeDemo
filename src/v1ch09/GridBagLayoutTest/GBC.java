package v1ch09.GridBagLayoutTest;

import java.awt.*;

public class GBC extends GridBagConstraints {
	/**
	 * Constructs a GBC with a given gridx and gridy position and all other grid
	 * 构造具有给定gridx和gridy位置以及所有其他网格的GBC
	 *
	 * @param gridx
	 * @param gridy
	 */
	public GBC(int gridx, int gridy) {
		this.gridx = gridx;
		this.gridy = gridy;
	}

	/**
	 * Constructs a GBC with given gridx, gridy, gridwidth, gridheight and all
	 * 使用给定的gridx，gridy，gridwidth，gridheight和all构造GBC
	 *
	 * @param gridx
	 * @param gridy
	 * @param gridwidth
	 * @param gridheight
	 */
	public GBC(int gridx, int gridy, int gridwidth, int gridheight) {
		this.gridx = gridx;
		this.gridy = gridy;
		this.gridwidth = gridwidth;
		this.gridheight = gridheight;
	}

	/**
	 * Sets the anchor.
	 * 设置锚点。
	 *
	 * @param anchor
	 * @return
	 */
	public GBC setAnchor(int anchor) {
		this.anchor = anchor;
		return this;
	}

	/**
	 * Sets the fill direction.
	 * 设置填充方向
	 *
	 * @param fill
	 * @return
	 */
	public GBC setFill(int fill) {
		this.fill = fill;
		return this;
	}

	/**
	 * Sets the cell weights.
	 * 设置单元格权重
	 *
	 * @param weightx
	 * @param weighty
	 * @return
	 */
	public GBC setWeight(double weightx, double weighty) {
		this.weightx = weightx;
		this.weighty = weighty;
		return this;
	}

	/**
	 * Sets the insets of this cell.
	 * 设置此单元格的insets。
	 *
	 * @param distance
	 * @return
	 */
	public GBC setInsets(int distance) {
		this.insets = new Insets(distance, distance, distance, distance);
		return this;
	}

	/**
	 * Sets the insets of this cell.
	 *
	 * @param top
	 * @param left
	 * @param bottom
	 * @param right
	 * @return
	 */
	public GBC setInsets(int top, int left, int bottom, int right) {
		this.insets = new Insets(top, left, bottom, right);
		return this;
	}

	/**
	 * Sets the internal padding
	 * 设置内部填充
	 *
	 * @param ipadx
	 * @param ipady
	 * @return
	 */
	public GBC setIpad(int ipadx, int ipady) {
		this.ipadx = ipadx;
		this.ipady = ipady;
		return this;
	}
}
