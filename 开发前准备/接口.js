/**
    @api { POST } /get/code 1.验证码获取
    @apiDescription 找回密码/注册使用、验证码可以存缓存，记得用了就作废了
    @apiName get-code
    @apiVersion 0.0.1
    @apiGroup User

    @apiSuccess { String } email 邮箱

    @apiSuccessExample 成功
                    {
                        status: 200,
                        message: '验证码已经发送到邮箱，请注意查收'
                    }
    @apiErrorExample 失败
                    {
                        status: 404,401,...,
                        message:"邮箱还未注册,......"
                    }

*/
/* =============================================================================== */
/**
    @api { POST } /register?code=xuydasdasdsaad 2.用户注册
    @apiDescription 用户注册使用的接口
    @apiName user-register
    @apiVersion 0.0.1
    @apiGroup User

    @apiSuccess { String } email 邮箱
    @apiSuccess { String } username 用户名
    @apiSuccess { String } password 密码

    @apiSuccessExample 成功
                    {
                        status: 200,
                        message: '注册成功,xxxx',
                        "user": {
                            username,
                            userId,
                            email,
                            createdAt,
                            updatedAt,
                        },
                        token: "tokenheader ac889875649a87c8567786dd65a76",
                    }
    @apiErrorExample 失败
                    {
                        status: 404,401,...,
                        message:"注册失败的原因"
                    }

*/
/* =============================================================================== */
/**
    @api { POST } /login 3.用户登录
    @apiDescription 用户登录使用的接口
    @apiName user-login
    @apiVersion 0.0.1
    @apiGroup User

    @apiSuccess { String } username 用户名
    @apiSuccess { String } password 密码
                    
    @apiSuccessExample 成功
                    {
                        status: 200,
                        message: '登录成功,xxxx',
                        "user": {
                            username,
                            userId,
                            email,
                            createdAt,
                            updatedAt,
                        },
                        token: "tokenheader ac889875649a87c8567786dd65a76",
                    }
    @apiErrorExample 失败
                    {
                        status: 404,401,...,
                        message:"登录失败的原因"
                    }

*/
/* =============================================================================== */
/**
    @api { PUT } /retrieve 4.用户找回密码
    @apiDescription 用户召回密码使用的接口
    @apiName user-retrieve
    @apiVersion 0.0.1
    @apiGroup User

    @apiSuccess { String } newPassword 新密码
    @apiSuccess { String } email 邮箱
    @apiSuccess { String } code 验证码

    @apiSuccessExample 成功
                    {
                        status: 200,
                        message: '找回成功,xxxx',
                    }
    @apiErrorExample 失败
                    {
                        status: 404,401,...,
                        message:"找回失败的原因"
                    }

*/
/* =============================================================================== */
/**
    @api { GET } /video/:page/:pageSize?search=videoTitle 5.搜索视频列表(别返回视频url，安全问题)
    @apiDescription 用户、管理员搜索视频列表，分页获取，模糊查询，两表查询，adminId变成admin_username
    @apiName video-page-pageSize-search
    @apiVersion 0.0.1
    @apiGroup UserOnAdmin
                    
    @apiSuccessExample 成功
                    {
                        status: 200,
                        message: '获取成功',
                        data: {
                            total,
                            videos: [
                                {
                                    videoId,
                                    videoTitle,
                                    videoImage,
                                    createdAt,
                                    updatedAt,
                                    adminUsername
                                }
                            ]
                        }
                    }
    @apiErrorExample 失败
                    {
                        status: 404,401,...,
                        message:"获取失败原因",
                        data: [] // 应该是空数组
                    }

*/
/* =============================================================================== */
/**
    @api { GET }  /video?videoId=1221312  6.视频详情
    @apiDescription 获取视频详情，获取对应的评论等
    @apiName video-detail
    @apiVersion 0.0.1
    @apiGroup UserOnAdmin
    
    @apiHeader { String } Authorization 验证token正确性
                    
    @apiSuccessExample 成功
                    {
                        status: 200,
                        message: '获取成功',
                        data:{
                                videoId,
                                videoUrl,
                                videoImage,
                                videoTitle,
                                videoDes,
                                createdAt,
                                updatedAt,
                                adminUsername,
                                comments: [
                                    {
                                        commentId,
                                        commentContent,
                                        createdAt,
                                        username, // 用户名,展示用的
                                    }
                                ]
                            }
                    }
    @apiErrorExample 失败
                    {
                        status: 404,401,...,
                        message:"获取失败原因",
                        data: {} // 应该是空对象，或者没有
                    }

*/
/* =============================================================================== */
/**
    @api { POST }  /comment/video  7.评论视频
    @apiDescription 对当前的视频进行评论
    @apiName comment-video
    @apiVersion 0.0.1
    @apiGroup User
    
    @apiHeader { String } Authorization 验证token正确性

    @apiSuccess { String } commentContent 评论内容
    @apiSuccess { String } videoId 评论的视频id
    @apiSuccessExample 成功
                    {
                        status: 200,
                        message: '获取成功'
                    }
    @apiErrorExample 失败
                    {
                        status: 404,401,...,
                        message:"失败原因"
                    }

*/
/* =============================================================================== */
/**
    @api { DELETE }  /comment/delete?commentId=xxx  8.删除评论
    @apiName comment-delete
    @apiDescription 删除当前自己的评论
    @apiVersion 0.0.1
    @apiGroup User
    
    @apiHeader { String } Authorization 验证token正确性

    @apiSuccessExample 成功
                    {
                        status: 200,
                        message: '删除评论成功'
                    }
    @apiErrorExample 失败
                    {
                        status: 404,401,...,
                        message:"删除评论失败原因"
                    }

*/
/* =============================================================================== */
/**
    @api { GET } /comment/:page/:pageSize?search=commentContent 9.搜索评论列表
    @apiDescription 用户、管理员搜索评论列表，分页获取，模糊查询，两表查询
    @apiName comment-page-pageSize-search
    @apiVersion 0.0.1
    @apiGroup UserOnAdmin
    
    @apiHeader { String } Authorization 验证token正确性
                    
    @apiSuccessExample 成功
                    {
                        status: 200,
                        message: '获取成功',
                        data: {
                            total,
                            comments: [
                                {
                                    videoId,
                                    commentId,
                                    commentContent,
                                    createdAt,
                                    username, // 用户名,展示用的
                                }
                            ]
                        }
                    }
    @apiErrorExample 失败
                    {
                        status: 404,401,...,
                        message:"获取失败原因",
                        data: [] // 应该是空数组
                    }

*/
/* =============================================================================== */
/**
    @api { POST } /admin/login 10.管理员登录
    @apiName admin-login
    @apiDescription 管理员通过用户名密码登录
    @apiVersion 0.0.1
    @apiGroup Admin

    @apiSuccess { String } username 用户名
    @apiSuccess { String } password 密码
    
    @apiSuccessExample 成功
                    {
                        status: 200,
                        message: '登录成功',
                        data:{
                            adminId,
                            adminUsername,
                        },
                        token: '1213sxgfxszhjvcghabvdhjwafajhvdhj',
                    }
    @apiErrorExample 失败
                    {
                        status: 404,401,...,
                        message:"登录失败原因"
                    }

*/

/* =============================================================================== */
/**
    @api { POST } /video/upload 11.上传视频/视频封面图
    @apiName admin-upload-video
    @apiDescription 管理员上传视频文件、视频封面图图片
    @apiVersion 0.0.1
    @apiGroup Admin

    @apiHeader { String } Authorization 验证token正确性

    @apiSuccess { FormData } file 视频文件流

    @apiSuccessExample 成功
                    {
                        status: 200,
                        message: '上传成功',
                        data: {
                            url, // 上传成功的视频url
                        }
                    }
    @apiErrorExample 失败
                    {
                        status: 404,401,...,
                        message:"上传失败原因"
                    }

*/
/* =============================================================================== */
/**
    @api { POST } /video/add 12.添加视频
    @apiName admin-add-video
    @apiDescription 管理员新增视频
    @apiVersion 0.0.1
    @apiGroup Admin

    @apiHeader { String } Authorization 验证token正确性

    @apiSuccess { String } videoUrl 视频url
    @apiSuccess { String } videoImage 视频封面图
    @apiSuccess { String } videoTitle 视频标题
    @apiSuccess { String } videoDes 视频描述

    @apiSuccessExample 成功
                    {
                        status: 200,
                        message: '新增成功'
                    }
    @apiErrorExample 失败
                    {
                        status: 404,401,...,
                        message:"新增失败原因"
                    }

*/
/* =============================================================================== */
/**
    @api { PUT } /video/update 13.修改视频
    @apiName admin-update-video
    @apiDescription 管理员修改视频信息
    @apiVersion 0.0.1
    @apiGroup Admin

    @apiHeader { String } Authorization 验证token正确性

    @apiSuccess { String } videoId 视频id
    @apiSuccess { String } videoUrl 视频url
    @apiSuccess { String } videoImage 视频封面图
    @apiSuccess { String } videoTitle 视频标题
    @apiSuccess { String } videoDes 视频描述

    @apiSuccessExample 成功
                    {
                        status: 200,
                        message: '修改成功'
                    }
    @apiErrorExample 失败
                    {
                        status: 404,401,...,
                        message:"修改失败原因"
                    }

*/
/* =============================================================================== */
/**
    @api { DELETE } /video/delete?videoId=xxx 14.删除视频
    @apiName admin-delete-video
    @apiDescription 管理员删除当前视频
    @apiVersion 0.0.1
    @apiGroup Admin

    @apiHeader { String } Authorization 验证token正确性

    @apiSuccessExample 成功
                    {
                        status: 200,
                        message: '删除成功'
                    }
    @apiErrorExample 失败
                    {
                        status: 404,401,...,
                        message:"删除失败原因"
                    }

*/
/* =============================================================================== */
/**
    @api { GET } /user/:page/:pageSize?search=username 15.用户列表搜索
    @apiName user-page-pageSize-search
    @apiDescription 用户列表，分页获取
    @apiVersion 0.0.1
    @apiGroup Admin
    
    @apiHeader { String } Authorization 验证token正确性
                    
    @apiSuccessExample 成功
                    {
                        status: 200,
                        message: '获取成功',
                        data: {
                            total,
                            users: [
                                {
                                    userId,
                                    username,
                                    email,
                                    createdAt,
                                    updateAt,
                                }
                            ]
                        }
                    }
    @apiErrorExample 失败
                    {
                        status: 404,401,...,
                        message:"获取失败原因",
                        data: [] // 应该是空数组
                    }

*/