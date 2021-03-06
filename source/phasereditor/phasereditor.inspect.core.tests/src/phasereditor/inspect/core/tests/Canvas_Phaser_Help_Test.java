// The MIT License (MIT)
//
// Copyright (c) 2015, 2016 Arian Fornaris
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
package phasereditor.inspect.core.tests;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Assert;
import org.junit.Test;

import phasereditor.inspect.core.InspectCore;
import phasereditor.inspect.core.jsdoc.PhaserJSDoc;

/**
 * @author arian
 *
 */
public class Canvas_Phaser_Help_Test {
	@SuppressWarnings("static-method")
	@Test
	public void test() throws IOException {
		Path wsPath = Paths.get(".").toAbsolutePath().getParent().getParent();
		Path projectPath = wsPath.resolve(InspectCore.RESOURCES_PLUGIN_ID);
		PhaserJSDoc jsDoc = new PhaserJSDoc(projectPath.resolve("phaser-master/src"),
				projectPath.resolve("phaser-version/phaser-custom/jsdoc/docs.json"));

		String[] memberNames = {
				//
				"Phaser.Sprite.frameName", //
				"Phaser.Sprite.x", //
				"Phaser.Sprite.y", //
				"Phaser.Sprite.angle", //
				"Phaser.Sprite.scale", //
				"Phaser.Sprite.pivot", //
				"Phaser.Sprite.anchor", //
				"Phaser.Sprite.anchor", //
				"Phaser.Sprite.tint", //
				"Phaser.Sprite.animations", //
				"Phaser.GameObjectFactory.physicsGroup", //
				"Phaser.Sprite.frame", //
				"Phaser.TileSprite.tilePosition", //
				"Phaser.TileSprite.tileScale", //
				"Phaser.TileSprite.width", //
				"Phaser.TileSprite.height"//
		};

		for (String name : memberNames) {
			String doc = jsDoc.getMemberHelp(name);
			Assert.assertTrue(name, !doc.equals("<No help available>"));
		}

		String[][] memeber_arg_tuples = {
				//
				{ "Phaser.Button", "callback" }, //
				{ "Phaser.Button", "callbackContext" }, //
				{ "Phaser.Button", "overFrame" }, //
				{ "Phaser.Button", "outFrame" }, //
				{ "Phaser.Button", "downFrame" }, //
				{ "Phaser.Button", "upFrame" },//
		};

		for (String[] tuple : memeber_arg_tuples) {
			String doc = jsDoc.getMethodArgHelp(tuple[0], tuple[1]);
			Assert.assertTrue(tuple[0] + "#" + tuple[1], !doc.equals("<No help available>"));
		}

	}
}
