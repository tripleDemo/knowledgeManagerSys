define({ "api": [
  {
    "type": " POST ",
    "url": "/video/add",
    "title": "12.添加视频",
    "name": "admin-add-video",
    "description": "<p>管理员新增视频</p>",
    "version": "0.0.1",
    "group": "Admin",
    "header": {
      "fields": {
        "Header": [
          {
            "group": "Header",
            "type": "String",
            "optional": false,
            "field": "Authorization",
            "description": "<p>验证token正确性</p>"
          }
        ]
      }
    },
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "videoUrl",
            "description": "<p>视频url</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "videoImage",
            "description": "<p>视频封面图</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "videoTitle",
            "description": "<p>视频标题</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "videoDes",
            "description": "<p>视频描述</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "成功",
          "content": "{\n    status: 200,\n    message: '新增成功'\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "失败",
          "content": "{\n    status: 404,401,...,\n    message:\"新增失败原因\"\n}",
          "type": "json"
        }
      ]
    },
    "filename": "./接口.js",
    "groupTitle": "Admin"
  },
  {
    "type": " DELETE ",
    "url": "/video/delete?videoId=xxx",
    "title": "14.删除视频",
    "name": "admin-delete-video",
    "description": "<p>管理员删除当前视频</p>",
    "version": "0.0.1",
    "group": "Admin",
    "header": {
      "fields": {
        "Header": [
          {
            "group": "Header",
            "type": "String",
            "optional": false,
            "field": "Authorization",
            "description": "<p>验证token正确性</p>"
          }
        ]
      }
    },
    "success": {
      "examples": [
        {
          "title": "成功",
          "content": "{\n    status: 200,\n    message: '删除成功'\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "失败",
          "content": "{\n    status: 404,401,...,\n    message:\"删除失败原因\"\n}",
          "type": "json"
        }
      ]
    },
    "filename": "./接口.js",
    "groupTitle": "Admin"
  },
  {
    "type": " POST ",
    "url": "/admin/login",
    "title": "10.管理员登录",
    "name": "admin-login",
    "description": "<p>管理员通过用户名密码登录</p>",
    "version": "0.0.1",
    "group": "Admin",
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "username",
            "description": "<p>用户名</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "password",
            "description": "<p>密码</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "成功",
          "content": "{\n    status: 200,\n    message: '登录成功',\n    data:{\n        adminId,\n        adminUsername,\n    },\n    token: '1213sxgfxszhjvcghabvdhjwafajhvdhj',\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "失败",
          "content": "{\n    status: 404,401,...,\n    message:\"登录失败原因\"\n}",
          "type": "json"
        }
      ]
    },
    "filename": "./接口.js",
    "groupTitle": "Admin"
  },
  {
    "type": " PUT ",
    "url": "/video/update",
    "title": "13.修改视频",
    "name": "admin-update-video",
    "description": "<p>管理员修改视频信息</p>",
    "version": "0.0.1",
    "group": "Admin",
    "header": {
      "fields": {
        "Header": [
          {
            "group": "Header",
            "type": "String",
            "optional": false,
            "field": "Authorization",
            "description": "<p>验证token正确性</p>"
          }
        ]
      }
    },
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "videoId",
            "description": "<p>视频id</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "videoUrl",
            "description": "<p>视频url</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "videoImage",
            "description": "<p>视频封面图</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "videoTitle",
            "description": "<p>视频标题</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "videoDes",
            "description": "<p>视频描述</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "成功",
          "content": "{\n    status: 200,\n    message: '修改成功'\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "失败",
          "content": "{\n    status: 404,401,...,\n    message:\"修改失败原因\"\n}",
          "type": "json"
        }
      ]
    },
    "filename": "./接口.js",
    "groupTitle": "Admin"
  },
  {
    "type": " POST ",
    "url": "/video/upload",
    "title": "11.上传视频/视频封面图",
    "name": "admin-upload-video",
    "description": "<p>管理员上传视频文件、视频封面图图片</p>",
    "version": "0.0.1",
    "group": "Admin",
    "header": {
      "fields": {
        "Header": [
          {
            "group": "Header",
            "type": "String",
            "optional": false,
            "field": "Authorization",
            "description": "<p>验证token正确性</p>"
          }
        ]
      }
    },
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "FormData",
            "optional": false,
            "field": "file",
            "description": "<p>视频文件流</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "成功",
          "content": "{\n    status: 200,\n    message: '上传成功',\n    data: {\n        url, // 上传成功的视频url\n    }\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "失败",
          "content": "{\n    status: 404,401,...,\n    message:\"上传失败原因\"\n}",
          "type": "json"
        }
      ]
    },
    "filename": "./接口.js",
    "groupTitle": "Admin"
  },
  {
    "type": " GET ",
    "url": "/user/:page/:pageSize?search=username",
    "title": "15.用户列表搜索",
    "name": "user-page-pageSize-search",
    "description": "<p>用户列表，分页获取</p>",
    "version": "0.0.1",
    "group": "Admin",
    "header": {
      "fields": {
        "Header": [
          {
            "group": "Header",
            "type": "String",
            "optional": false,
            "field": "Authorization",
            "description": "<p>验证token正确性</p>"
          }
        ]
      }
    },
    "success": {
      "examples": [
        {
          "title": "成功",
          "content": "{\n    status: 200,\n    message: '获取成功',\n    data: {\n        total,\n        users: [\n            {\n                userId,\n                username,\n                email,\n                createdAt,\n                updateAt,\n            }\n        ]\n    }\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "失败",
          "content": "{\n    status: 404,401,...,\n    message:\"获取失败原因\",\n    data: [] // 应该是空数组\n}",
          "type": "json"
        }
      ]
    },
    "filename": "./接口.js",
    "groupTitle": "Admin"
  },
  {
    "type": " GET ",
    "url": "/comment/:page/:pageSize?search=commentContent",
    "title": "9.搜索评论列表",
    "description": "<p>用户、管理员搜索评论列表，分页获取，模糊查询，两表查询</p>",
    "name": "comment-page-pageSize-search",
    "version": "0.0.1",
    "group": "UserOnAdmin",
    "header": {
      "fields": {
        "Header": [
          {
            "group": "Header",
            "type": "String",
            "optional": false,
            "field": "Authorization",
            "description": "<p>验证token正确性</p>"
          }
        ]
      }
    },
    "success": {
      "examples": [
        {
          "title": "成功",
          "content": "{\n    status: 200,\n    message: '获取成功',\n    data: {\n        total,\n        comments: [\n            {\n                videoId,\n                commentId,\n                commentContent,\n                createdAt,\n                username, // 用户名,展示用的\n            }\n        ]\n    }\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "失败",
          "content": "{\n    status: 404,401,...,\n    message:\"获取失败原因\",\n    data: [] // 应该是空数组\n}",
          "type": "json"
        }
      ]
    },
    "filename": "./接口.js",
    "groupTitle": "UserOnAdmin"
  },
  {
    "type": " GET ",
    "url": "/video?videoId=1221312",
    "title": "6.视频详情",
    "description": "<p>获取视频详情，获取对应的评论等</p>",
    "name": "video-detail",
    "version": "0.0.1",
    "group": "UserOnAdmin",
    "header": {
      "fields": {
        "Header": [
          {
            "group": "Header",
            "type": "String",
            "optional": false,
            "field": "Authorization",
            "description": "<p>验证token正确性</p>"
          }
        ]
      }
    },
    "success": {
      "examples": [
        {
          "title": "成功",
          "content": "{\n    status: 200,\n    message: '获取成功',\n    data:{\n            videoId,\n            videoUrl,\n            videoImage,\n            videoTitle,\n            videoDes,\n            createdAt,\n            updatedAt,\n            adminUsername,\n            comments: [\n                {\n                    commentId,\n                    commentContent,\n                    createdAt,\n                    username, // 用户名,展示用的\n                }\n            ]\n        }\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "失败",
          "content": "{\n    status: 404,401,...,\n    message:\"获取失败原因\",\n    data: {} // 应该是空对象，或者没有\n}",
          "type": "json"
        }
      ]
    },
    "filename": "./接口.js",
    "groupTitle": "UserOnAdmin"
  },
  {
    "type": " GET ",
    "url": "/video/:page/:pageSize?search=videoTitle",
    "title": "5.搜索视频列表(别返回视频url，安全问题)",
    "description": "<p>用户、管理员搜索视频列表，分页获取，模糊查询，两表查询，adminId变成admin_username</p>",
    "name": "video-page-pageSize-search",
    "version": "0.0.1",
    "group": "UserOnAdmin",
    "success": {
      "examples": [
        {
          "title": "成功",
          "content": "{\n    status: 200,\n    message: '获取成功',\n    data: {\n        total,\n        videos: [\n            {\n                videoId,\n                videoTitle,\n                videoImage,\n                createdAt,\n                updatedAt,\n                adminUsername\n            }\n        ]\n    }\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "失败",
          "content": "{\n    status: 404,401,...,\n    message:\"获取失败原因\",\n    data: [] // 应该是空数组\n}",
          "type": "json"
        }
      ]
    },
    "filename": "./接口.js",
    "groupTitle": "UserOnAdmin"
  },
  {
    "type": " DELETE ",
    "url": "/comment/delete?commentId=xxx",
    "title": "8.删除评论",
    "name": "comment-delete",
    "description": "<p>删除当前自己的评论</p>",
    "version": "0.0.1",
    "group": "User",
    "header": {
      "fields": {
        "Header": [
          {
            "group": "Header",
            "type": "String",
            "optional": false,
            "field": "Authorization",
            "description": "<p>验证token正确性</p>"
          }
        ]
      }
    },
    "success": {
      "examples": [
        {
          "title": "成功",
          "content": "{\n    status: 200,\n    message: '删除评论成功'\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "失败",
          "content": "{\n    status: 404,401,...,\n    message:\"删除评论失败原因\"\n}",
          "type": "json"
        }
      ]
    },
    "filename": "./接口.js",
    "groupTitle": "User"
  },
  {
    "type": " POST ",
    "url": "/comment/video",
    "title": "7.评论视频",
    "description": "<p>对当前的视频进行评论</p>",
    "name": "comment-video",
    "version": "0.0.1",
    "group": "User",
    "header": {
      "fields": {
        "Header": [
          {
            "group": "Header",
            "type": "String",
            "optional": false,
            "field": "Authorization",
            "description": "<p>验证token正确性</p>"
          }
        ]
      }
    },
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "commentContent",
            "description": "<p>评论内容</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "videoId",
            "description": "<p>评论的视频id</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "成功",
          "content": "{\n    status: 200,\n    message: '获取成功'\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "失败",
          "content": "{\n    status: 404,401,...,\n    message:\"失败原因\"\n}",
          "type": "json"
        }
      ]
    },
    "filename": "./接口.js",
    "groupTitle": "User"
  },
  {
    "type": " POST ",
    "url": "/get/code",
    "title": "1.验证码获取",
    "description": "<p>找回密码/注册使用、验证码可以存缓存，记得用了就作废了</p>",
    "name": "get-code",
    "version": "0.0.1",
    "group": "User",
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "email",
            "description": "<p>邮箱</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "成功",
          "content": "{\n    status: 200,\n    message: '验证码已经发送到邮箱，请注意查收'\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "失败",
          "content": "{\n    status: 404,401,...,\n    message:\"邮箱还未注册,......\"\n}",
          "type": "json"
        }
      ]
    },
    "filename": "./接口.js",
    "groupTitle": "User"
  },
  {
    "type": " POST ",
    "url": "/login",
    "title": "3.用户登录",
    "description": "<p>用户登录使用的接口</p>",
    "name": "user-login",
    "version": "0.0.1",
    "group": "User",
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "username",
            "description": "<p>用户名</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "password",
            "description": "<p>密码</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "成功",
          "content": "{\n    status: 200,\n    message: '登录成功,xxxx',\n    \"user\": {\n        username,\n        userId,\n        email,\n        createdAt,\n        updatedAt,\n    },\n    token: \"tokenheader ac889875649a87c8567786dd65a76\",\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "失败",
          "content": "{\n    status: 404,401,...,\n    message:\"登录失败的原因\"\n}",
          "type": "json"
        }
      ]
    },
    "filename": "./接口.js",
    "groupTitle": "User"
  },
  {
    "type": " POST ",
    "url": "/register?code=xuydasdasdsaad",
    "title": "2.用户注册",
    "description": "<p>用户注册使用的接口</p>",
    "name": "user-register",
    "version": "0.0.1",
    "group": "User",
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "email",
            "description": "<p>邮箱</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "username",
            "description": "<p>用户名</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "password",
            "description": "<p>密码</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "成功",
          "content": "{\n    status: 200,\n    message: '注册成功,xxxx',\n    \"user\": {\n        username,\n        userId,\n        email,\n        createdAt,\n        updatedAt,\n    },\n    token: \"tokenheader ac889875649a87c8567786dd65a76\",\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "失败",
          "content": "{\n    status: 404,401,...,\n    message:\"注册失败的原因\"\n}",
          "type": "json"
        }
      ]
    },
    "filename": "./接口.js",
    "groupTitle": "User"
  },
  {
    "type": " PUT ",
    "url": "/retrieve",
    "title": "4.用户找回密码",
    "description": "<p>用户召回密码使用的接口</p>",
    "name": "user-retrieve",
    "version": "0.0.1",
    "group": "User",
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "newPassword",
            "description": "<p>新密码</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "email",
            "description": "<p>邮箱</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "code",
            "description": "<p>验证码</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "成功",
          "content": "{\n    status: 200,\n    message: '找回成功,xxxx',\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "失败",
          "content": "{\n    status: 404,401,...,\n    message:\"找回失败的原因\"\n}",
          "type": "json"
        }
      ]
    },
    "filename": "./接口.js",
    "groupTitle": "User"
  }
] });
