package generated

final case class Data1390(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1390 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1390 = copy(value = value * k)
  def addTag(t: String): Data1390 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1390 = copy(meta = meta.updated(k, v))
  def merge(other: Data1390): Data1390 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1390 {
  given Ordering[Data1390] = Ordering.by(_.id)
  def empty: Data1390 = Data1390(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1390 =
    Data1390(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1390] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
