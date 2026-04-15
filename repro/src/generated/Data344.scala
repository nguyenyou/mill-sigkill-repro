package generated

final case class Data344(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data344 = copy(name = name.toUpperCase)
  def scale(k: Double): Data344 = copy(value = value * k)
  def addTag(t: String): Data344 = copy(tags = t :: tags)
  def put(k: String, v: String): Data344 = copy(meta = meta.updated(k, v))
  def merge(other: Data344): Data344 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data344 {
  given Ordering[Data344] = Ordering.by(_.id)
  def empty: Data344 = Data344(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data344 =
    Data344(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data344] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
