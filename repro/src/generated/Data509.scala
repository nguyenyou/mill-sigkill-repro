package generated

final case class Data509(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data509 = copy(name = name.toUpperCase)
  def scale(k: Double): Data509 = copy(value = value * k)
  def addTag(t: String): Data509 = copy(tags = t :: tags)
  def put(k: String, v: String): Data509 = copy(meta = meta.updated(k, v))
  def merge(other: Data509): Data509 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data509 {
  given Ordering[Data509] = Ordering.by(_.id)
  def empty: Data509 = Data509(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data509 =
    Data509(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data509] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
