package generated

final case class Data748(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data748 = copy(name = name.toUpperCase)
  def scale(k: Double): Data748 = copy(value = value * k)
  def addTag(t: String): Data748 = copy(tags = t :: tags)
  def put(k: String, v: String): Data748 = copy(meta = meta.updated(k, v))
  def merge(other: Data748): Data748 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data748 {
  given Ordering[Data748] = Ordering.by(_.id)
  def empty: Data748 = Data748(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data748 =
    Data748(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data748] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
