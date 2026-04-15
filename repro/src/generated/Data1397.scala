package generated

final case class Data1397(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1397 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1397 = copy(value = value * k)
  def addTag(t: String): Data1397 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1397 = copy(meta = meta.updated(k, v))
  def merge(other: Data1397): Data1397 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1397 {
  given Ordering[Data1397] = Ordering.by(_.id)
  def empty: Data1397 = Data1397(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1397 =
    Data1397(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1397] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
