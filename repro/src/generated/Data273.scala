package generated

final case class Data273(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data273 = copy(name = name.toUpperCase)
  def scale(k: Double): Data273 = copy(value = value * k)
  def addTag(t: String): Data273 = copy(tags = t :: tags)
  def put(k: String, v: String): Data273 = copy(meta = meta.updated(k, v))
  def merge(other: Data273): Data273 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data273 {
  given Ordering[Data273] = Ordering.by(_.id)
  def empty: Data273 = Data273(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data273 =
    Data273(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data273] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
