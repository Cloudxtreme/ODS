#include "coverage-counters.h"
#include <stddef.h>
#include "coverage.h"
#include "util.h"

/* vswitchd/bridge.c:1204 */
struct coverage_counter bridge_flush_count = { "bridge_flush", 0, 0 };

/* vswitchd/bridge.c:2521 */
struct coverage_counter bridge_process_flow_count = { "bridge_process_flow", 0, 0 };

/* vswitchd/bridge.c:555 */
struct coverage_counter bridge_reconfigure_count = { "bridge_reconfigure", 0, 0 };

/* lib/dpif.c:384 */
struct coverage_counter dpif_destroy_count = { "dpif_destroy", 0, 0 };

/* lib/dpif.c:934 */
struct coverage_counter dpif_execute_count = { "dpif_execute", 0, 0 };

/* lib/dpif.c:825 */
struct coverage_counter dpif_flow_del_count = { "dpif_flow_del", 0, 0 };

/* lib/dpif.c:697 */
struct coverage_counter dpif_flow_flush_count = { "dpif_flow_flush", 0, 0 };

/* lib/dpif.c:722, lib/dpif.c:774 */
struct coverage_counter dpif_flow_get_count = { "dpif_flow_get", 0, 0 };

/* lib/dpif.c:806 */
struct coverage_counter dpif_flow_put_count = { "dpif_flow_put", 0, 0 };

/* lib/dpif.c:850 */
struct coverage_counter dpif_flow_query_list_count = { "dpif_flow_query_list", 0, 0 };

/* lib/dpif.c:866 */
struct coverage_counter dpif_flow_query_list_n_count = { "dpif_flow_query_list_n", 0, 0 };

/* lib/dpif.c:443 */
struct coverage_counter dpif_port_add_count = { "dpif_port_add", 0, 0 };

/* lib/dpif.c:467 */
struct coverage_counter dpif_port_del_count = { "dpif_port_del", 0, 0 };

/* lib/dpif.c:683 */
struct coverage_counter dpif_port_group_set_count = { "dpif_port_group_set", 0, 0 };

/* lib/dpif.c:1064 */
struct coverage_counter dpif_purge_count = { "dpif_purge", 0, 0 };

/* lib/flow.c:148 */
struct coverage_counter flow_extract_count = { "flow_extract", 0, 0 };

/* lib/hmap.c:125 */
struct coverage_counter hmap_expand_count = { "hmap_expand", 0, 0 };

/* lib/hmap.c:92 */
struct coverage_counter hmap_pathological_count = { "hmap_pathological", 0, 0 };

/* lib/hmap.c:149 */
struct coverage_counter hmap_reserve_count = { "hmap_reserve", 0, 0 };

/* lib/hmap.c:136 */
struct coverage_counter hmap_shrink_count = { "hmap_shrink", 0, 0 };

/* lib/lockfile.c:120 */
struct coverage_counter lockfile_error_count = { "lockfile_error", 0, 0 };

/* lib/lockfile.c:92 */
struct coverage_counter lockfile_lock_count = { "lockfile_lock", 0, 0 };

/* lib/lockfile.c:115 */
struct coverage_counter lockfile_timeout_count = { "lockfile_timeout", 0, 0 };

/* lib/lockfile.c:139 */
struct coverage_counter lockfile_unlock_count = { "lockfile_unlock", 0, 0 };

/* lib/mac-learning.c:304 */
struct coverage_counter mac_learning_expired_count = { "mac_learning_expired", 0, 0 };

/* lib/mac-learning.c:232 */
struct coverage_counter mac_learning_learned_count = { "mac_learning_learned", 0, 0 };

/* lib/netdev.c:760, lib/netdev-linux.c:1837 */
struct coverage_counter netdev_add_router_count = { "netdev_add_router", 0, 0 };

/* lib/netdev-linux.c:1926 */
struct coverage_counter netdev_arp_lookup_count = { "netdev_arp_lookup", 0, 0 };

/* lib/netdev-linux.c:3497 */
struct coverage_counter netdev_ethtool_count = { "netdev_ethtool", 0, 0 };

/* lib/netdev-linux.c:3452 */
struct coverage_counter netdev_get_hwaddr_count = { "netdev_get_hwaddr", 0, 0 };

/* lib/netdev-linux.c:3417 */
struct coverage_counter netdev_get_ifindex_count = { "netdev_get_ifindex", 0, 0 };

/* lib/netdev.c:933, lib/netdev-linux.c:1051 */
struct coverage_counter netdev_get_stats_count = { "netdev_get_stats", 0, 0 };

/* lib/netdev-linux.c:1301 */
struct coverage_counter netdev_get_vlan_vid_count = { "netdev_get_vlan_vid", 0, 0 };

/* lib/netdev.c:484 */
struct coverage_counter netdev_received_count = { "netdev_received", 0, 0 };

/* lib/netdev.c:539 */
struct coverage_counter netdev_sent_count = { "netdev_sent", 0, 0 };

/* lib/netdev-linux.c:3477 */
struct coverage_counter netdev_set_hwaddr_count = { "netdev_set_hwaddr", 0, 0 };

/* lib/netdev-linux.c:1391 */
struct coverage_counter netdev_set_policing_count = { "netdev_set_policing", 0, 0 };

/* lib/netlink.c:321, lib/netlink.c:410 */
struct coverage_counter netlink_overflow_count = { "netlink_overflow", 0, 0 };

/* lib/netlink.c:339 */
struct coverage_counter netlink_received_count = { "netlink_received", 0, 0 };

/* lib/netlink.c:302 */
struct coverage_counter netlink_recv_retry_count = { "netlink_recv_retry", 0, 0 };

/* lib/netlink.c:238 */
struct coverage_counter netlink_send_count = { "netlink_send", 0, 0 };

/* lib/netlink.c:219, lib/netlink.c:250 */
struct coverage_counter netlink_sent_count = { "netlink_sent", 0, 0 };

/* ofproto/ofproto.c:2828 */
struct coverage_counter odp_overflow_count = { "odp_overflow", 0, 0 };

/* ofproto/ofproto.c:2051 */
struct coverage_counter ofproto_add_wc_flow_count = { "ofproto_add_wc_flow", 0, 0 };

/* ofproto/ofproto.c:3372 */
struct coverage_counter ofproto_agg_request_count = { "ofproto_agg_request", 0, 0 };

/* ofproto/ofproto.c:2921 */
struct coverage_counter ofproto_costly_flags_count = { "ofproto_costly_flags", 0, 0 };

/* ofproto/ofproto.c:4173 */
struct coverage_counter ofproto_ctlr_action_count = { "ofproto_ctlr_action", 0, 0 };

/* ofproto/ofproto.c:2082 */
struct coverage_counter ofproto_del_wc_flow_count = { "ofproto_del_wc_flow", 0, 0 };

/* ofproto/ofproto.c:2160 */
struct coverage_counter ofproto_dp_missed_count = { "ofproto_dp_missed", 0, 0 };

/* ofproto/ofproto.c:2301 */
struct coverage_counter ofproto_error_count = { "ofproto_error", 0, 0 };

/* ofproto/ofproto.c:1155 */
struct coverage_counter ofproto_expiration_count = { "ofproto_expiration", 0, 0 };

/* ofproto/ofproto.c:4333 */
struct coverage_counter ofproto_expired_count = { "ofproto_expired", 0, 0 };

/* ofproto/ofproto.c:3263 */
struct coverage_counter ofproto_flows_req_count = { "ofproto_flows_req", 0, 0 };

/* ofproto/ofproto.c:1332 */
struct coverage_counter ofproto_flush_count = { "ofproto_flush", 0, 0 };

/* ofproto/ofproto.c:2505 */
struct coverage_counter ofproto_invalidated_count = { "ofproto_invalidated", 0, 0 };

/* ofproto/ofproto.c:3746 */
struct coverage_counter ofproto_mod_wc_flow_count = { "ofproto_mod_wc_flow", 0, 0 };

/* ofproto/ofproto.c:4118 */
struct coverage_counter ofproto_no_packet_in_count = { "ofproto_no_packet_in", 0, 0 };

/* ofproto/ofproto.c:2111 */
struct coverage_counter ofproto_odp_unchanged_count = { "ofproto_odp_unchanged", 0, 0 };

/* ofproto/ofproto.c:1738 */
struct coverage_counter ofproto_ofconn_stuck_count = { "ofproto_ofconn_stuck", 0, 0 };

/* ofproto/ofproto.c:2802 */
struct coverage_counter ofproto_ofp2odp_count = { "ofproto_ofp2odp", 0, 0 };

/* ofproto/ofproto.c:4127 */
struct coverage_counter ofproto_packet_in_count = { "ofproto_packet_in", 0, 0 };

/* ofproto/ofproto.c:2881 */
struct coverage_counter ofproto_packet_out_count = { "ofproto_packet_out", 0, 0 };

/* ofproto/ofproto.c:3456 */
struct coverage_counter ofproto_queue_req_count = { "ofproto_queue_req", 0, 0 };

/* ofproto/ofproto.c:4028 */
struct coverage_counter ofproto_recv_openflow_count = { "ofproto_recv_openflow", 0, 0 };

/* ofproto/ofproto.c:1198 */
struct coverage_counter ofproto_revalidate_count = { "ofproto_revalidate", 0, 0 };

/* ofproto/ofproto.c:4221 */
struct coverage_counter ofproto_revalidate_moved_count = { "ofproto_revalidate_moved", 0, 0 };

/* ofproto/ofproto.c:4213 */
struct coverage_counter ofproto_revalidate_rule_count = { "ofproto_revalidate_rule", 0, 0 };

/* ofproto/ofproto.c:2070 */
struct coverage_counter ofproto_subrule_create_count = { "ofproto_subrule_create", 0, 0 };

/* ofproto/ofproto.c:4410 */
struct coverage_counter ofproto_unexpected_rule_count = { "ofproto_unexpected_rule", 0, 0 };

/* ofproto/ofproto.c:2565 */
struct coverage_counter ofproto_uninstallable_count = { "ofproto_uninstallable", 0, 0 };

/* ofproto/ofproto.c:1550 */
struct coverage_counter ofproto_update_port_count = { "ofproto_update_port", 0, 0 };

/* ofproto/pktbuf.c:192 */
struct coverage_counter pktbuf_buffer_unknown_count = { "pktbuf_buffer_unknown", 0, 0 };

/* ofproto/pktbuf.c:197 */
struct coverage_counter pktbuf_null_cookie_count = { "pktbuf_null_cookie", 0, 0 };

/* ofproto/pktbuf.c:184 */
struct coverage_counter pktbuf_retrieved_count = { "pktbuf_retrieved", 0, 0 };

/* ofproto/pktbuf.c:187 */
struct coverage_counter pktbuf_reuse_error_count = { "pktbuf_reuse_error", 0, 0 };

/* lib/poll-loop.c:72 */
struct coverage_counter poll_fd_wait_count = { "poll_fd_wait", 0, 0 };

/* lib/poll-loop.c:183 */
struct coverage_counter poll_zero_timeout_count = { "poll_zero_timeout", 0, 0 };

/* lib/process.c:312 */
struct coverage_counter process_run_count = { "process_run", 0, 0 };

/* lib/process.c:493 */
struct coverage_counter process_run_capture_count = { "process_run_capture", 0, 0 };

/* lib/process.c:592 */
struct coverage_counter process_sigchld_count = { "process_sigchld", 0, 0 };

/* lib/process.c:197 */
struct coverage_counter process_start_count = { "process_start", 0, 0 };

/* lib/stream.c:504 */
struct coverage_counter pstream_open_count = { "pstream_open", 0, 0 };

/* lib/rconn.c:1016 */
struct coverage_counter rconn_discarded_count = { "rconn_discarded", 0, 0 };

/* lib/rconn.c:622 */
struct coverage_counter rconn_overflow_count = { "rconn_overflow", 0, 0 };

/* lib/rconn.c:582 */
struct coverage_counter rconn_queued_count = { "rconn_queued", 0, 0 };

/* lib/rconn.c:929 */
struct coverage_counter rconn_sent_count = { "rconn_sent", 0, 0 };

/* lib/rtnetlink.c:161 */
struct coverage_counter rtnetlink_changed_count = { "rtnetlink_changed", 0, 0 };

/* lib/stream-ssl.c:464 */
struct coverage_counter ssl_session_count = { "ssl_session", 0, 0 };

/* lib/stream-ssl.c:466 */
struct coverage_counter ssl_session_reused_count = { "ssl_session_reused", 0, 0 };

/* lib/stream.c:201 */
struct coverage_counter stream_open_count = { "stream_open", 0, 0 };

/* lib/unixctl.c:284 */
struct coverage_counter unixctl_received_count = { "unixctl_received", 0, 0 };

/* lib/unixctl.c:147 */
struct coverage_counter unixctl_replied_count = { "unixctl_replied", 0, 0 };

/* lib/util.c:42, lib/util.c:59, lib/util.c:70 */
struct coverage_counter util_xalloc_count = { "util_xalloc", 0, 0 };

/* lib/vconn.c:224 */
struct coverage_counter vconn_open_count = { "vconn_open", 0, 0 };

/* lib/vconn.c:532 */
struct coverage_counter vconn_received_count = { "vconn_received", 0, 0 };

/* lib/vconn.c:596 */
struct coverage_counter vconn_sent_count = { "vconn_sent", 0, 0 };

struct coverage_counter *coverage_counters[] = {
    &bridge_flush_count,
    &bridge_process_flow_count,
    &bridge_reconfigure_count,
    &dpif_destroy_count,
    &dpif_execute_count,
    &dpif_flow_del_count,
    &dpif_flow_flush_count,
    &dpif_flow_get_count,
    &dpif_flow_put_count,
    &dpif_flow_query_list_count,
    &dpif_flow_query_list_n_count,
    &dpif_port_add_count,
    &dpif_port_del_count,
    &dpif_port_group_set_count,
    &dpif_purge_count,
    &flow_extract_count,
    &hmap_expand_count,
    &hmap_pathological_count,
    &hmap_reserve_count,
    &hmap_shrink_count,
    &lockfile_error_count,
    &lockfile_lock_count,
    &lockfile_timeout_count,
    &lockfile_unlock_count,
    &mac_learning_expired_count,
    &mac_learning_learned_count,
    &netdev_add_router_count,
    &netdev_arp_lookup_count,
    &netdev_ethtool_count,
    &netdev_get_hwaddr_count,
    &netdev_get_ifindex_count,
    &netdev_get_stats_count,
    &netdev_get_vlan_vid_count,
    &netdev_received_count,
    &netdev_sent_count,
    &netdev_set_hwaddr_count,
    &netdev_set_policing_count,
    &netlink_overflow_count,
    &netlink_received_count,
    &netlink_recv_retry_count,
    &netlink_send_count,
    &netlink_sent_count,
    &odp_overflow_count,
    &ofproto_add_wc_flow_count,
    &ofproto_agg_request_count,
    &ofproto_costly_flags_count,
    &ofproto_ctlr_action_count,
    &ofproto_del_wc_flow_count,
    &ofproto_dp_missed_count,
    &ofproto_error_count,
    &ofproto_expiration_count,
    &ofproto_expired_count,
    &ofproto_flows_req_count,
    &ofproto_flush_count,
    &ofproto_invalidated_count,
    &ofproto_mod_wc_flow_count,
    &ofproto_no_packet_in_count,
    &ofproto_odp_unchanged_count,
    &ofproto_ofconn_stuck_count,
    &ofproto_ofp2odp_count,
    &ofproto_packet_in_count,
    &ofproto_packet_out_count,
    &ofproto_queue_req_count,
    &ofproto_recv_openflow_count,
    &ofproto_revalidate_count,
    &ofproto_revalidate_moved_count,
    &ofproto_revalidate_rule_count,
    &ofproto_subrule_create_count,
    &ofproto_unexpected_rule_count,
    &ofproto_uninstallable_count,
    &ofproto_update_port_count,
    &pktbuf_buffer_unknown_count,
    &pktbuf_null_cookie_count,
    &pktbuf_retrieved_count,
    &pktbuf_reuse_error_count,
    &poll_fd_wait_count,
    &poll_zero_timeout_count,
    &process_run_count,
    &process_run_capture_count,
    &process_sigchld_count,
    &process_start_count,
    &pstream_open_count,
    &rconn_discarded_count,
    &rconn_overflow_count,
    &rconn_queued_count,
    &rconn_sent_count,
    &rtnetlink_changed_count,
    &ssl_session_count,
    &ssl_session_reused_count,
    &stream_open_count,
    &unixctl_received_count,
    &unixctl_replied_count,
    &util_xalloc_count,
    &vconn_open_count,
    &vconn_received_count,
    &vconn_sent_count,
};
size_t coverage_n_counters = ARRAY_SIZE(coverage_counters);
