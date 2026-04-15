package generated

final case class Data777(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data777 = copy(name = name.toUpperCase)
  def scale(k: Double): Data777 = copy(value = value * k)
  def addTag(t: String): Data777 = copy(tags = t :: tags)
  def put(k: String, v: String): Data777 = copy(meta = meta.updated(k, v))
  def merge(other: Data777): Data777 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data777 {
  given Ordering[Data777] = Ordering.by(_.id)
  def empty: Data777 = Data777(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data777 =
    Data777(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data777] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
