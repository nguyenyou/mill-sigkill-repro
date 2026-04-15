package generated

final case class Data1359(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1359 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1359 = copy(value = value * k)
  def addTag(t: String): Data1359 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1359 = copy(meta = meta.updated(k, v))
  def merge(other: Data1359): Data1359 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1359 {
  given Ordering[Data1359] = Ordering.by(_.id)
  def empty: Data1359 = Data1359(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1359 =
    Data1359(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1359] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
