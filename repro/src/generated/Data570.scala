package generated

final case class Data570(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data570 = copy(name = name.toUpperCase)
  def scale(k: Double): Data570 = copy(value = value * k)
  def addTag(t: String): Data570 = copy(tags = t :: tags)
  def put(k: String, v: String): Data570 = copy(meta = meta.updated(k, v))
  def merge(other: Data570): Data570 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data570 {
  given Ordering[Data570] = Ordering.by(_.id)
  def empty: Data570 = Data570(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data570 =
    Data570(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data570] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
