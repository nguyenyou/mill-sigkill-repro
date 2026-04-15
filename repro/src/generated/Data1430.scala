package generated

final case class Data1430(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1430 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1430 = copy(value = value * k)
  def addTag(t: String): Data1430 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1430 = copy(meta = meta.updated(k, v))
  def merge(other: Data1430): Data1430 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1430 {
  given Ordering[Data1430] = Ordering.by(_.id)
  def empty: Data1430 = Data1430(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1430 =
    Data1430(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1430] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
