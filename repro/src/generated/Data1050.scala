package generated

final case class Data1050(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1050 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1050 = copy(value = value * k)
  def addTag(t: String): Data1050 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1050 = copy(meta = meta.updated(k, v))
  def merge(other: Data1050): Data1050 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1050 {
  given Ordering[Data1050] = Ordering.by(_.id)
  def empty: Data1050 = Data1050(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1050 =
    Data1050(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1050] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
