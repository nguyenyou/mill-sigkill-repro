package generated

final case class Data333(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data333 = copy(name = name.toUpperCase)
  def scale(k: Double): Data333 = copy(value = value * k)
  def addTag(t: String): Data333 = copy(tags = t :: tags)
  def put(k: String, v: String): Data333 = copy(meta = meta.updated(k, v))
  def merge(other: Data333): Data333 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data333 {
  given Ordering[Data333] = Ordering.by(_.id)
  def empty: Data333 = Data333(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data333 =
    Data333(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data333] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
