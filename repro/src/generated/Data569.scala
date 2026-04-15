package generated

final case class Data569(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data569 = copy(name = name.toUpperCase)
  def scale(k: Double): Data569 = copy(value = value * k)
  def addTag(t: String): Data569 = copy(tags = t :: tags)
  def put(k: String, v: String): Data569 = copy(meta = meta.updated(k, v))
  def merge(other: Data569): Data569 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data569 {
  given Ordering[Data569] = Ordering.by(_.id)
  def empty: Data569 = Data569(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data569 =
    Data569(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data569] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
