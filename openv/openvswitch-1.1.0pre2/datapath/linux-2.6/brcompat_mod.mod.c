#include <linux/module.h>
#include <linux/vermagic.h>
#include <linux/compiler.h>

MODULE_INFO(vermagic, VERMAGIC_STRING);

struct module __this_module
__attribute__((section(".gnu.linkonce.this_module"))) = {
 .name = KBUILD_MODNAME,
 .init = init_module,
#ifdef CONFIG_MODULE_UNLOAD
 .exit = cleanup_module,
#endif
 .arch = MODULE_ARCH_INIT,
};

static const struct modversion_info ____versions[]
__used
__attribute__((section("__versions"))) = {
	{ 0xae141548, "module_layout" },
	{ 0xdca0e950, "genl_register_family" },
	{ 0xab910849, "single_open" },
	{ 0xd0d8621b, "strlen" },
	{ 0x49439411, "genl_unregister_family" },
	{ 0xe4b7d1f2, "single_release" },
	{ 0xe66df013, "seq_puts" },
	{ 0xc7a4fbed, "rtnl_lock" },
	{ 0x901e58ed, "skb_clone" },
	{ 0x2bc801eb, "remove_proc_entry" },
	{ 0x446da885, "mutex_unlock" },
	{ 0x712aa29b, "_spin_lock_irqsave" },
	{ 0x19fae545, "dp_ioctl_hook" },
	{ 0x1f33bd3a, "seq_read" },
	{ 0xc499ae1e, "kstrdup" },
	{ 0xe2d5255a, "strcmp" },
	{ 0x5ce21240, "proc_mkdir" },
	{ 0xb86e4ab9, "random32" },
	{ 0xb72397d5, "printk" },
	{ 0x5152e605, "memcmp" },
	{ 0x2da418b5, "copy_to_user" },
	{ 0x4307b811, "nla_put" },
	{ 0x16305289, "warn_slowpath_null" },
	{ 0xc7423ae, "mutex_lock" },
	{ 0x4b07e779, "_spin_unlock_irqrestore" },
	{ 0xa0068f7b, "netlink_unicast" },
	{ 0xf6b374cb, "init_net" },
	{ 0xca49a0b0, "__dev_get_by_index" },
	{ 0x95cbadbf, "__alloc_skb" },
	{ 0xfbf219b, "netlink_broadcast" },
	{ 0xf0fdf6cb, "__stack_chk_fail" },
	{ 0xa58b6804, "nla_parse" },
	{ 0xb156aefd, "kfree_skb" },
	{ 0x714242a0, "create_proc_entry" },
	{ 0x8b607574, "brioctl_set" },
	{ 0x3c2d9226, "seq_lseek" },
	{ 0x37a0cba, "kfree" },
	{ 0x20385c58, "genl_register_mc_group" },
	{ 0xcc7387af, "genl_register_ops" },
	{ 0xe456bd3a, "complete" },
	{ 0x5cf7185, "skb_put" },
	{ 0x3e1f073d, "wait_for_completion_timeout" },
	{ 0xf2a644fb, "copy_from_user" },
	{ 0x6e720ff2, "rtnl_unlock" },
	{ 0xe914e41e, "strcpy" },
};

static const char __module_depends[]
__used
__attribute__((section(".modinfo"))) =
"depends=openvswitch_mod";

