package generated

final case class Data505(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data505 = copy(name = name.toUpperCase)
  def scale(k: Double): Data505 = copy(value = value * k)
  def addTag(t: String): Data505 = copy(tags = t :: tags)
  def put(k: String, v: String): Data505 = copy(meta = meta.updated(k, v))
  def merge(other: Data505): Data505 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data505 {
  given Ordering[Data505] = Ordering.by(_.id)
  def empty: Data505 = Data505(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data505 =
    Data505(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data505] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
