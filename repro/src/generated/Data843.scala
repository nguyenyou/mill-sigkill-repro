package generated

final case class Data843(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data843 = copy(name = name.toUpperCase)
  def scale(k: Double): Data843 = copy(value = value * k)
  def addTag(t: String): Data843 = copy(tags = t :: tags)
  def put(k: String, v: String): Data843 = copy(meta = meta.updated(k, v))
  def merge(other: Data843): Data843 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data843 {
  given Ordering[Data843] = Ordering.by(_.id)
  def empty: Data843 = Data843(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data843 =
    Data843(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data843] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
