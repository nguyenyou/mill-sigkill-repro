package generated

final case class Data260(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data260 = copy(name = name.toUpperCase)
  def scale(k: Double): Data260 = copy(value = value * k)
  def addTag(t: String): Data260 = copy(tags = t :: tags)
  def put(k: String, v: String): Data260 = copy(meta = meta.updated(k, v))
  def merge(other: Data260): Data260 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data260 {
  given Ordering[Data260] = Ordering.by(_.id)
  def empty: Data260 = Data260(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data260 =
    Data260(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data260] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
