// The MIT License (MIT)
//
// Copyright (c) 2015 Arian Fornaris
//
// Permission is hereby granted, free of charge, to any person obtaining a
// copy of this software and associated documentation files (the
// "Software"), to deal in the Software without restriction, including
// without limitation the rights to use, copy, modify, merge, publish,
// distribute, sublicense, and/or sell copies of the Software, and to permit
// persons to whom the Software is furnished to do so, subject to the
// following conditions: The above copyright notice and this permission
// notice shall be included in all copies or substantial portions of the
// Software.
//
// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS
// OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
// MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN
// NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
// DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
// OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE
// USE OR OTHER DEALINGS IN THE SOFTWARE.
package phasereditor.atlas.core;

import org.json.JSONObject;
import org.w3c.dom.Element;

public class AtlasFrame {
	private String _name;
	private int _frameX;
	private int _frameY;
	private int _frameW;
	private int _frameH;
	private int _spriteX;
	private int _spriteY;
	private int _spriteW;
	private int _spriteH;
	private int _sourceW;
	private int _sourceH;

	public static AtlasFrame fromXMLItem(Element node) {
		AtlasFrame fi = new AtlasFrame();
		fi.setName(node.getAttribute("name"));
		fi.setFrameX(Integer.parseInt(node.getAttribute("x")));
		fi.setFrameY(Integer.parseInt(node.getAttribute("y")));
		fi.setFrameW(Integer.parseInt(node.getAttribute("width")));
		fi.setFrameH(Integer.parseInt(node.getAttribute("height")));
		fi.setSpriteX(fi.getFrameX());
		fi.setSpriteY(fi.getFrameY());
		fi.setSpriteW(fi.getFrameW());
		fi.setSpriteH(fi.getFrameH());
		fi.setSourceW(fi.getFrameW());
		fi.setSourceH(fi.getFrameH());

		if (node.hasAttribute("frameX")) {
			fi.setName(node.getAttribute("name"));
			fi.setSpriteX(Math.abs(Integer.parseInt(node.getAttribute("frameX"))));
			fi.setSpriteY(Math.abs(Integer.parseInt(node.getAttribute("frameY"))));
			fi.setSourceW(Math.abs(Integer.parseInt(node.getAttribute("frameWidth"))));
			fi.setSourceH(Math.abs(Integer.parseInt(node.getAttribute("frameHeight"))));
		}

		return fi;
	}

	public static AtlasFrame fromArrayItem(JSONObject jsonItem) {
		AtlasFrame fi = new AtlasFrame();
		fi._name = jsonItem.getString("filename");
		update(fi, jsonItem);
		return fi;
	}

	public static AtlasFrame fromHashItem(String name, JSONObject jsonItem) {
		AtlasFrame fi = new AtlasFrame();
		fi._name = name;
		update(fi, jsonItem);
		return fi;
	}

	private static void update(AtlasFrame fi, JSONObject jsonItem) {
		{
			JSONObject rect = jsonItem.getJSONObject("frame");
			fi._frameX = rect.getInt("x");
			fi._frameY = rect.getInt("y");
			fi._frameW = rect.getInt("w");
			fi._frameH = rect.getInt("h");
		}

		{
			JSONObject rect = jsonItem.optJSONObject("spriteSourceSize");
			if (rect == null) {
				fi._spriteX = fi._frameX;
				fi._spriteY = fi._frameY;
				fi._spriteW = fi._frameW;
				fi._spriteH = fi._frameH;
			} else {
				fi._spriteX = rect.getInt("x");
				fi._spriteY = rect.getInt("y");
				fi._spriteW = rect.getInt("w");
				fi._spriteH = rect.getInt("h");
			}
		}

		{
			JSONObject rect = jsonItem.optJSONObject("sourceSize");
			if (rect == null) {
				fi._sourceW = fi._frameW;
				fi._sourceH = fi._frameH;
			} else {
				fi._sourceW = rect.getInt("w");
				fi._sourceH = rect.getInt("h");
			}
		}
	}

	public void update(AtlasFrame frame) {
		_frameH = frame._frameH;
		_frameW = frame._frameW;
		_frameX = frame._frameX;
		_frameY = frame._frameY;

		_spriteH = frame._spriteH;
		_spriteW = frame._spriteW;
		_spriteX = frame._spriteX;
		_spriteY = frame._spriteY;

		_sourceW = frame._sourceW;
		_sourceH = frame._sourceH;

		_name = frame._name;
	}

	public AtlasFrame() {
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public int getFrameX() {
		return _frameX;
	}

	public void setFrameX(int frameX) {
		_frameX = frameX;
	}

	public int getFrameY() {
		return _frameY;
	}

	public void setFrameY(int frameY) {
		_frameY = frameY;
	}

	public int getFrameW() {
		return _frameW;
	}

	public void setFrameW(int frameW) {
		_frameW = frameW;
	}

	public int getFrameH() {
		return _frameH;
	}

	public void setFrameH(int frameH) {
		_frameH = frameH;
	}

	public int getSpriteX() {
		return _spriteX;
	}

	public void setSpriteX(int spriteX) {
		_spriteX = spriteX;
	}

	public int getSpriteY() {
		return _spriteY;
	}

	public void setSpriteY(int spriteY) {
		_spriteY = spriteY;
	}

	public int getSpriteW() {
		return _spriteW;
	}

	public void setSpriteW(int spriteW) {
		_spriteW = spriteW;
	}

	public int getSpriteH() {
		return _spriteH;
	}

	public void setSpriteH(int spriteH) {
		_spriteH = spriteH;
	}

	public int getSourceW() {
		return _sourceW;
	}

	public void setSourceW(int sourceW) {
		_sourceW = sourceW;
	}

	public int getSourceH() {
		return _sourceH;
	}

	public void setSourceH(int sourceH) {
		_sourceH = sourceH;
	}
}
