package generated

final case class Data152(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data152 = copy(name = name.toUpperCase)
  def scale(k: Double): Data152 = copy(value = value * k)
  def addTag(t: String): Data152 = copy(tags = t :: tags)
  def put(k: String, v: String): Data152 = copy(meta = meta.updated(k, v))
  def merge(other: Data152): Data152 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data152 {
  given Ordering[Data152] = Ordering.by(_.id)
  def empty: Data152 = Data152(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data152 =
    Data152(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data152] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
