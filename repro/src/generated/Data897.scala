package generated

final case class Data897(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data897 = copy(name = name.toUpperCase)
  def scale(k: Double): Data897 = copy(value = value * k)
  def addTag(t: String): Data897 = copy(tags = t :: tags)
  def put(k: String, v: String): Data897 = copy(meta = meta.updated(k, v))
  def merge(other: Data897): Data897 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data897 {
  given Ordering[Data897] = Ordering.by(_.id)
  def empty: Data897 = Data897(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data897 =
    Data897(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data897] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
