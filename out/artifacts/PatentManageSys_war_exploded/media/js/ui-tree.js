var UITree = function () {

    return {
        //main function to initiate the module
        init: function () {
            // handle collapse/expand for tree_1
            $('#tree_1_collapse').click(function () {
                $('.tree-toggle', $('#tree_1 > li > ul')).addClass("closed");
                $('.branch', $('#tree_1 > li > ul')).removeClass("in");
            });

            $('#tree_1_expand').click(function () {
                $('.tree-toggle', $('#tree_1 > li > ul')).removeClass("closed");
                $('.branch', $('#tree_1 > li > ul')).addClass("in");
            });

            // handle collapse/expand for tree_2
            $('#tree_2_collapse').click(function () {
                $('.tree-toggle', $('#tree_2 > li > ul')).addClass("closed");
                $('.branch', $('#tree_2 > li > ul')).removeClass("in");
            });

            $('#tree_2_expand').click(function () {
                //$('.tree-toggle', $('#tree_2 > li > ul')).removeClass("closed");
                // iterate tree nodes and exppand all nodes
                $('.tree-toggle', $('#tree_2 > li > ul')).each(function () {
                    $(this).click(); //trigger tree node click
                });
                $('.branch', $('#tree_2 > li > ul')).addClass("in");
            });

            //这是捕捉选择事件树的叶子一个简单的例子，不支
            /*$("#tree_1").on("nodeselect.tree.data-api", "[data-role=leaf]", function (e) {
                var output = "";

                output += "Node nodeselect event fired:\n";
                output += "Node Type: leaf\n";
                output += "Value: " + ((e.node.value) ? e.node.value : e.node.el.text()) + "\n";
                output += "Parentage: " + e.node.parentage.join("/");

                alert(output+" //这是捕捉选择事件树的叶子一个简单的例子，不支");
            });*/

            //这是捕捉选择事件树上一个简单的例子，不离开
            /*$("#tree_1").on("nodeselect.tree.data-api", "[role=branch]", function (e) {
                var output = "Node nodeselect event fired:\n"; + "Node Type: branch\n" + "Value: " + ((e.node.value) ? e.node.value : e.node.el.text()) + "\n" + "Parentage: " + e.node.parentage.join("/") + "\n";

                alert(output+"这是捕捉选择事件树上一个简单的例子，不离开");
            });

            //听“openbranch”事件。寻找e.node，是用户打开实际结

            $("#tree_1").on("openbranch.tree", "[data-toggle=branch]", function (e) {

                var output = "Node openbranch event fired:\n" + "Node Type: branch\n" + "Value: " + ((e.node.value) ? e.node.value : e.node.el.text()) + "\n" + "Parentage: " + e.node.parentage.join("/") + "\n";

                alert(output+"听“openbranch”事件。寻找e.node，是用户打开实际结");
            });*/


            //听“closebranch”事件。寻找e.node，这是实际的节点用户关闭

            /*$("#tree_1").on("closebranch.tree", "[data-toggle=branch]", function (e) {

                var output = "Node closebranch event fired:\n" + "Node Type: branch\n" + "Value: " + ((e.node.value) ? e.node.value : e.node.el.text()) + "\n" + "Parentage: " + e.node.parentage.join("/") + "\n";

                alert(output+"听“closebranch”事件。寻找e.node，这是实际的节点用户关闭");
            });*/
        }

    };

}();