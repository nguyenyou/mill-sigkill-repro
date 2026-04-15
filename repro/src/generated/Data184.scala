package generated

final case class Data184(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data184 = copy(name = name.toUpperCase)
  def scale(k: Double): Data184 = copy(value = value * k)
  def addTag(t: String): Data184 = copy(tags = t :: tags)
  def put(k: String, v: String): Data184 = copy(meta = meta.updated(k, v))
  def merge(other: Data184): Data184 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data184 {
  given Ordering[Data184] = Ordering.by(_.id)
  def empty: Data184 = Data184(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data184 =
    Data184(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data184] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
